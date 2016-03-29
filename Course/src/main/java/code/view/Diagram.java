package code.view;


import code.controller.Service;
import code.model.ValutaType;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;

public class Diagram extends JFrame {
    private Service service;

    public Diagram(Service service) {
        super("Динаміка валют");
        this.service = service;
        JFreeChart barChart = ChartFactory.createBarChart(
                "Відчувай зміну",
                "Category",
                "Score",
                createDataset(ValutaType.values()),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        setContentPane(chartPanel);
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }

    private CategoryDataset createDataset(ValutaType[] valutaTypes) {
        final String firstDecade = "First Decade";
        final String secondDecade = "Second Decade";
        final String thirdDecade = "Third Decade";
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        for (ValutaType valutaType : valutaTypes) {
            final String value = valutaType.toString();
            dataset.addValue(service.getAverageCourseForDecade(valutaType,1), value, firstDecade);
            dataset.addValue(service.getAverageCourseForDecade(valutaType,2), value, secondDecade);
            dataset.addValue(service.getAverageCourseForDecade(valutaType,3), value, thirdDecade);
        }


        return dataset;
    }




}
