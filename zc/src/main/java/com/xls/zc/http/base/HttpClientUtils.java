package com.xls.zc.http.base;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * SSO使用客户端请求类
 */
public class HttpClientUtils {

    public  synchronized HttpClient warpClient(){
        HttpClient client = new DefaultHttpClient();
        try {

            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);

            SSLSocketFactory sf = new SSLSocketFactoryNew(trustStore);
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);  //允许所有主机的验证

            HttpParams params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.DEFAULT_CONTENT_CHARSET);
            HttpProtocolParams.setUseExpectContinue(params, true);

            // 设置连接管理器的超时
            ConnManagerParams.setTimeout(params, 10000);
            // 设置连接超时
            HttpConnectionParams.setConnectionTimeout(params, 10000);
            // 设置socket超时
            HttpConnectionParams.setSoTimeout(params, 10000);
            // 设置http https支持
            SchemeRegistry schReg = new SchemeRegistry();
            schReg.register(new Scheme("https", sf, 443));

            ClientConnectionManager conm = client.getConnectionManager();
            conm.getSchemeRegistry().register(new Scheme("https", sf, 443));
            client= new DefaultHttpClient(conm, params);

        } catch (Exception e) {
            e.printStackTrace();
            return new DefaultHttpClient();
        }
        return client;
    }
}

class SSLSocketFactoryNew extends SSLSocketFactory {
   SSLContext sslContext = SSLContext.getInstance("TLS");
   public SSLSocketFactoryNew(KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
       super(truststore);
       TrustManager tm = new X509TrustManager() {
           public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
           }
           public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
           }
           public X509Certificate[] getAcceptedIssuers() {
               return null;
           }
       };
       sslContext.init(null, new TrustManager[] { tm }, null);
   }
   @Override
   public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException {
       return sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
   }
   @Override
   public Socket createSocket() throws IOException {
       return sslContext.getSocketFactory().createSocket();
   }
}