/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

/**
 *
 * @author PIOTREK
 */
@Named(value = "chartBean")
@RequestScoped
public class ChartBean {
    
     private LineChartModel lineModel;

    /**
     * Creates a new instance of ChartBean
     */
    public ChartBean() {
    }
    
    @PostConstruct
    public void init() {
        setLineModel(new LineChartModel());
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Sinus");
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Cosinus");
        for(int i=0; i<=360; i+=10) {
            series1.set(i, Math.sin(Math.toRadians(i)));
            series2.set(i, Math.cos(Math.toRadians(i)));
        }
        lineModel.addSeries(series1);
        lineModel.addSeries(series2);
        lineModel.setTitle("Funkcje trygonometryczne");
        lineModel.setZoom(true);
        lineModel.setLegendPosition("e");
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(-1);
        yAxis.setMax(1);
        Axis xAxis = lineModel.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(360);
    }

    /**
     * @return the lineModel
     */
    public LineChartModel getLineModel() {
        return lineModel;
    }

    /**
     * @param lineModel the lineModel to set
     */
    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }
}
