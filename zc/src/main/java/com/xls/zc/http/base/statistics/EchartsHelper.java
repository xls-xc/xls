package com.xls.zc.http.base.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @copyright
 * @license    
 * @link       
 *
 * Echarts统计图表类
 * 
 * @author zxy
 * Created 2017/4/13 11:10
 */
public class EchartsHelper {

    /**
     * 调色盘颜色数组
     */
    public static String[] colorArr = new String[]{"#2095f2","#c23531", "#61a0a8", "#d48265", "#91c7ae", "#749f83",  "#ca8622", "#bda29a", "#6e7074", "#546570", "#c4ccd3"};

    /**
     * 折线图(line-stack)
     * @param params
     * @param seriesParams
     * @return
     */
    public static HashMap<String, Object> getLineStack(HashMap<String, Object> params, List<HashMap<String, Object>> seriesParams){
        //标题
        HashMap<String, Object> titleConfig = new HashMap<>();
        titleConfig.put("text", params.get("title_text"));
        titleConfig.put("x", "center");

        //提示框组件
        HashMap<String, Object> tooltipConfig = new HashMap<>();
        tooltipConfig.put("trigger", "axis");
        tooltipConfig.put("backgroundColor", "rgba(0,0,0,0.4)");

        //工具栏
        HashMap<String, Object> toolboxConfig = new HashMap<>();
        toolboxConfig.put("show", true);
        toolboxConfig.put("orient", "horizontal");
        toolboxConfig.put("showTitle", true);
        HashMap<String, Object> toolbox_feature_saveAsImageConfig = new HashMap<>();
        toolbox_feature_saveAsImageConfig.put("show", true);
        toolboxConfig.put("feature", new HashMap<String, Object>(){{put("saveAsImage", toolbox_feature_saveAsImageConfig);}});

        //图例组件
        HashMap<String, Object> legendConfig = new HashMap<>();
        legendConfig.put("data", params.get("legend_data"));
        legendConfig.put("x", "center");
        legendConfig.put("y", "bottom");

        //直角坐标系内绘图网格
        HashMap<String, Object> gridConfig = new HashMap<>();
        gridConfig.put("containLabel", true);
        gridConfig.put("left", "2%");
        gridConfig.put("right", "2%");

        //直角坐标系 grid 中的 x 轴
        HashMap<String, Object> xAxisConfig = new HashMap<>();
        xAxisConfig.put("type", "category");
        xAxisConfig.put("boundaryGap", false);
        xAxisConfig.put("data", params.get("xAxis_data"));
        HashMap<String, Object> xAxis_AxisLine_LineStyleConfig = new HashMap<>();
        xAxis_AxisLine_LineStyleConfig.put("color", "#666");
        HashMap<String, Object> xAxis_AxisLineConfig = new HashMap<>();
        xAxis_AxisLineConfig.put("lineStyle", xAxis_AxisLine_LineStyleConfig);
        xAxisConfig.put("axisLine", xAxis_AxisLineConfig);

        //直角坐标系 grid 中的 y 轴
        HashMap<String, Object> yAxisConfig = new HashMap<>();
        yAxisConfig.put("type", "value");
        HashMap<String, Object> yAxis_AxisLine_LineStyleConfig = new HashMap<>();
        yAxis_AxisLine_LineStyleConfig.put("color", "#666");
        HashMap<String, Object> yAxis_AxisLineConfig = new HashMap<>();
        yAxis_AxisLineConfig.put("lineStyle", yAxis_AxisLine_LineStyleConfig);
        yAxisConfig.put("axisLine", yAxis_AxisLineConfig);

        //系列列表，各项统计值
        List<Object> seriesConfig = new ArrayList<>();
        for(int i = 0; i < seriesParams.size(); i++){
            HashMap<String, Object> seriesItemConfig = new HashMap<>();
            seriesItemConfig.put("type", "line");
            seriesItemConfig.put("name", seriesParams.get(i).get("name"));
            seriesItemConfig.put("data", seriesParams.get(i).get("data"));
            seriesConfig.add(seriesItemConfig);
        }

        //获得统计Json
        HashMap<String, Object> chartsMap = new HashMap<>();
        chartsMap.put("color", colorArr);
        chartsMap.put("title", titleConfig);
        chartsMap.put("tooltip", tooltipConfig);
        chartsMap.put("toolbox", toolboxConfig);
        chartsMap.put("legend", legendConfig);
        chartsMap.put("grid", gridConfig);
        chartsMap.put("xAxis", xAxisConfig);
        chartsMap.put("yAxis", yAxisConfig);
        chartsMap.put("series", seriesConfig);
        return chartsMap;
    }

    /**
     * 柱状图
     * @param params
     * @param seriesParams
     * @return
     */
    public static HashMap<String, Object> getBarTickAlign(HashMap<String, Object> params, List<HashMap<String, Object>> seriesParams){
        //标题
        HashMap<String, Object> titleConfig = new HashMap<>();
        titleConfig.put("text", params.get("title_text"));
        titleConfig.put("x", "center");

        //提示框组件
        HashMap<String, Object> tooltipConfig = new HashMap<>();
        tooltipConfig.put("trigger", "axis");
        tooltipConfig.put("backgroundColor", "rgba(0,0,0,0.4)");

        //工具栏
        HashMap<String, Object> toolboxConfig = new HashMap<>();
        toolboxConfig.put("show", true);
        toolboxConfig.put("orient", "horizontal");
        toolboxConfig.put("showTitle", true);
        HashMap<String, Object> toolbox_feature_saveAsImageConfig = new HashMap<>();
        toolbox_feature_saveAsImageConfig.put("show", true);
        toolboxConfig.put("feature", new HashMap<String, Object>(){{put("saveAsImage", toolbox_feature_saveAsImageConfig);}});

        //直角坐标系内绘图网格
        HashMap<String, Object> gridConfig = new HashMap<>();
        gridConfig.put("containLabel", true);
        gridConfig.put("left", "2%");
        gridConfig.put("right", "2%");

        //直角坐标系 grid 中的 x 轴
        HashMap<String, Object> xAxisConfig = new HashMap<>();
        xAxisConfig.put("type", "category");
        xAxisConfig.put("boundaryGap", false);
        xAxisConfig.put("data", params.get("xAxis_data"));
        HashMap<String, Object> xAxis_AxisLine_LineStyleConfig = new HashMap<>();
        xAxis_AxisLine_LineStyleConfig.put("color", "#666");
        HashMap<String, Object> xAxis_AxisLineConfig = new HashMap<>();
        xAxis_AxisLineConfig.put("lineStyle", xAxis_AxisLine_LineStyleConfig);
        xAxisConfig.put("axisLine", xAxis_AxisLineConfig);

        //直角坐标系 grid 中的 y 轴
        HashMap<String, Object> yAxisConfig = new HashMap<>();
        yAxisConfig.put("type", "value");
        HashMap<String, Object> yAxis_AxisLine_LineStyleConfig = new HashMap<>();
        yAxis_AxisLine_LineStyleConfig.put("color", "#666");
        HashMap<String, Object> yAxis_AxisLineConfig = new HashMap<>();
        yAxis_AxisLineConfig.put("lineStyle", yAxis_AxisLine_LineStyleConfig);
        yAxisConfig.put("axisLine", yAxis_AxisLineConfig);

        //系列列表，各项统计值
        List<Object> seriesConfig = new ArrayList<>();
        for(int i = 0; i < seriesParams.size(); i++){
            HashMap<String, Object> seriesItemConfig = new HashMap<>();
            seriesItemConfig.put("type", "bar");
            seriesItemConfig.put("name", seriesParams.get(i).get("name"));
            seriesItemConfig.put("data", seriesParams.get(i).get("data"));
            seriesConfig.add(seriesItemConfig);
        }

        //获得统计Json
        HashMap<String, Object> chartsMap = new HashMap<>();
        chartsMap.put("color", colorArr);
        chartsMap.put("title", titleConfig);
        chartsMap.put("tooltip", tooltipConfig);
        chartsMap.put("toolbox", toolboxConfig);
        chartsMap.put("grid", gridConfig);
        chartsMap.put("xAxis", xAxisConfig);
        chartsMap.put("yAxis", yAxisConfig);
        chartsMap.put("series", seriesConfig);
        return chartsMap;
    }

    /**
     * 地图
     * @param params
     * @param seriesParams
     * @return
     */
    public static HashMap<String, Object> getMapChinaDataRange(HashMap<String, Object> params, List<HashMap<String, Object>> seriesParams){
        //标题
        HashMap<String, Object> titleConfig = new HashMap<>();
        titleConfig.put("text", params.get("title_text"));
        titleConfig.put("x", "center");

        //提示框组件
        HashMap<String, Object> tooltipConfig = new HashMap<>();
        tooltipConfig.put("trigger", "axis");
        tooltipConfig.put("backgroundColor", "rgba(0,0,0,0.4)");

        //工具栏
        HashMap<String, Object> toolboxConfig = new HashMap<>();
        toolboxConfig.put("show", true);
        toolboxConfig.put("orient", "horizontal");
        toolboxConfig.put("showTitle", true);
        HashMap<String, Object> toolbox_feature_saveAsImageConfig = new HashMap<>();
        toolbox_feature_saveAsImageConfig.put("show", true);
        toolboxConfig.put("feature", new HashMap<String, Object>(){{put("saveAsImage", toolbox_feature_saveAsImageConfig);}});

        //视觉映射组件
        HashMap<String, Object> visualMapConfig = new HashMap<>();
        visualMapConfig.put("min", 0);
        //由于最大值可能为0，造成显示错误，所以默认最大值加上10
        double max = Double.valueOf(params.get("visualMap_max").toString());
        if (max<=0) {
            max = 10;
        }else{
            max = (int)Math.ceil(max/10);
            max = max * 10;
            max = max + 10;
        }
        visualMapConfig.put("max", max);
        visualMapConfig.put("left", "left");
        visualMapConfig.put("top", "bottom");
        visualMapConfig.put("text", new String[]{"高","低"});
        visualMapConfig.put("calculable", true);

        //系列列表，每项图形上的文本标签设置默认值
        HashMap<String, Object> seriesItemLabelConfig = new HashMap<>();
        seriesItemLabelConfig.put("normal", new HashMap<String, Object>(){{put("show", true);}});
        seriesItemLabelConfig.put("emphasis", new HashMap<String, Object>(){{put("show", true);}});
        //系列列表，各项统计值
        List<Object> seriesConfig = new ArrayList<>();
        for(int i = 0; i < seriesParams.size(); i++){
            HashMap<String, Object> seriesItemConfig = new HashMap<>();
            seriesItemConfig.put("type", "map");
            seriesItemConfig.put("mapType", "china");
            seriesItemConfig.put("label", seriesItemLabelConfig);
            seriesItemConfig.put("name", seriesParams.get(i).get("name"));
            seriesItemConfig.put("data", seriesParams.get(i).get("data"));
            seriesConfig.add(seriesItemConfig);
        }

        //获得统计Json
        HashMap<String, Object> chartsMap = new HashMap<>();
        chartsMap.put("title", titleConfig);
        chartsMap.put("tooltip", tooltipConfig);
        chartsMap.put("toolbox", toolboxConfig);
        chartsMap.put("visualMap", visualMapConfig);
        chartsMap.put("series", seriesConfig);
        return chartsMap;
    }

    /**
     * 横向柱状图（bar-y-category）
     * @param params
     * @param seriesParams
     * @return
     */
    public static HashMap<String, Object> getBarYCategory(HashMap<String, Object> params, List<HashMap<String, Object>> seriesParams){
        //标题
        HashMap<String, Object> titleConfig = new HashMap<>();
        titleConfig.put("text", params.get("title_text"));
        titleConfig.put("x", "center");

        //提示框组件
        HashMap<String, Object> tooltipConfig = new HashMap<>();
        tooltipConfig.put("trigger", "axis");
        tooltipConfig.put("axisPointer", new HashMap<String, Object>(){{put("type", "shadow");}});
        tooltipConfig.put("backgroundColor", "rgba(0,0,0,0.4)");

        //工具栏
        HashMap<String, Object> toolboxConfig = new HashMap<>();
        toolboxConfig.put("show", true);
        toolboxConfig.put("orient", "horizontal");
        toolboxConfig.put("showTitle", true);
        HashMap<String, Object> toolbox_feature_saveAsImageConfig = new HashMap<>();
        toolbox_feature_saveAsImageConfig.put("show", true);
        toolboxConfig.put("feature", new HashMap<String, Object>(){{put("saveAsImage", toolbox_feature_saveAsImageConfig);}});

        //图例组件
        HashMap<String, Object> legendConfig = new HashMap<>();
        legendConfig.put("data", params.get("legend_data"));
        legendConfig.put("x", "center");
        legendConfig.put("y", "bottom");

        //直角坐标系内绘图网格
        HashMap<String, Object> gridConfig = new HashMap<>();
        gridConfig.put("containLabel", true);
        gridConfig.put("left", "2%");
        gridConfig.put("right", "2%");

        //直角坐标系 grid 中的 x 轴
        HashMap<String, Object> xAxisConfig = new HashMap<>();
        xAxisConfig.put("type", "value");
        xAxisConfig.put("boundaryGap", false);
        HashMap<String, Object> xAxis_AxisLine_LineStyleConfig = new HashMap<>();
        xAxis_AxisLine_LineStyleConfig.put("color", "#666");
        HashMap<String, Object> xAxis_AxisLineConfig = new HashMap<>();
        xAxis_AxisLineConfig.put("lineStyle", xAxis_AxisLine_LineStyleConfig);
        xAxisConfig.put("axisLine", xAxis_AxisLineConfig);

        //直角坐标系 grid 中的 y 轴
        HashMap<String, Object> yAxisConfig = new HashMap<>();
        yAxisConfig.put("type", "category");
        yAxisConfig.put("data", params.get("yAxis_data"));
        HashMap<String, Object> yAxis_AxisLine_LineStyleConfig = new HashMap<>();
        yAxis_AxisLine_LineStyleConfig.put("color", "#666");
        HashMap<String, Object> yAxis_AxisLineConfig = new HashMap<>();
        yAxis_AxisLineConfig.put("lineStyle", yAxis_AxisLine_LineStyleConfig);
        yAxisConfig.put("axisLine", yAxis_AxisLineConfig);

        //系列列表，各项统计值
        List<Object> seriesConfig = new ArrayList<>();
        for(int i = 0; i < seriesParams.size(); i++){
            HashMap<String, Object> seriesItemConfig = new HashMap<>();
            seriesItemConfig.put("type", "bar");
            seriesItemConfig.put("name", seriesParams.get(i).get("name"));
            seriesItemConfig.put("data", seriesParams.get(i).get("data"));
            seriesConfig.add(seriesItemConfig);
        }

        //获得统计Json
        HashMap<String, Object> chartsMap = new HashMap<>();
        chartsMap.put("color", colorArr);
        chartsMap.put("title", titleConfig);
        chartsMap.put("tooltip", tooltipConfig);
        chartsMap.put("toolbox", toolboxConfig);
        chartsMap.put("legend", legendConfig);
        chartsMap.put("grid", gridConfig);
        chartsMap.put("xAxis", xAxisConfig);
        chartsMap.put("yAxis", yAxisConfig);
        chartsMap.put("series", seriesConfig);
        return chartsMap;
    }

    /**
     * 饼图（pie-simple）
     * @param params
     * @param seriesParams
     * @return
     */
    public static HashMap<String, Object> getPieSimple(HashMap<String, Object> params, List<HashMap<String, Object>> seriesParams){
        //标题
        HashMap<String, Object> titleConfig = new HashMap<>();
        titleConfig.put("text", params.get("title_text"));
        titleConfig.put("x", "center");

        //提示框组件
        HashMap<String, Object> tooltipConfig = new HashMap<>();
        tooltipConfig.put("trigger", "item");
        tooltipConfig.put("axisPointer", new HashMap<String, Object>(){{put("type", "shadow");}});
        tooltipConfig.put("backgroundColor", "rgba(0,0,0,0.4)");

        //工具栏
        HashMap<String, Object> toolboxConfig = new HashMap<>();
        toolboxConfig.put("show", true);
        toolboxConfig.put("orient", "horizontal");
        toolboxConfig.put("showTitle", true);
        HashMap<String, Object> toolbox_feature_saveAsImageConfig = new HashMap<>();
        toolbox_feature_saveAsImageConfig.put("show", true);
        toolboxConfig.put("feature", new HashMap<String, Object>(){{put("saveAsImage", toolbox_feature_saveAsImageConfig);}});

        //图例组件
        HashMap<String, Object> legendConfig = new HashMap<>();
        legendConfig.put("data", params.get("legend_data"));
        legendConfig.put("orient", "vertical");
        legendConfig.put("left", "left");

        //系列列表，各项统计值
        List<Object> seriesConfig = new ArrayList<>();
        for(int i = 0; i < seriesParams.size(); i++){
            HashMap<String, Object> seriesItemConfig = new HashMap<>();
            seriesItemConfig.put("type", "pie");
            seriesItemConfig.put("radius", "55%");
            seriesItemConfig.put("center", new String[]{"50%","60%"});
            seriesItemConfig.put("name", seriesParams.get(i).get("name"));
            seriesItemConfig.put("data", seriesParams.get(i).get("data"));
            //itemStyle
            HashMap<String,Object> seriesItemItemStyleConfig = new HashMap<>();
            seriesItemItemStyleConfig.put("shadowBlur", 10);
            seriesItemItemStyleConfig.put("shadowOffsetX", 0);
            seriesItemItemStyleConfig.put("shadowColor", "rgba(0, 0, 0, 0.5)");
            seriesItemConfig.put("itemStyle", new HashMap<String,Object>(){{put("emphasis",seriesItemItemStyleConfig);}});
            seriesConfig.add(seriesItemConfig);
        }

        //获得统计Json
        HashMap<String, Object> chartsMap = new HashMap<>();
        //chartsMap.put("color", colorArr);
        chartsMap.put("title", titleConfig);
        chartsMap.put("tooltip", tooltipConfig);
        chartsMap.put("toolbox", toolboxConfig);
        chartsMap.put("legend", legendConfig);
        chartsMap.put("series", seriesConfig);
        return chartsMap;
    }
}
