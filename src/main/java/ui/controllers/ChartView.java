package ui.controllers;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;

import entities.Invoice;
import entities.Item;

import org.primefaces.model.chart.ChartSeries;

@ManagedBean
public class ChartView implements Serializable {

	private static final long serialVersionUID = 4275539870948289837L;

	private BarChartModel barModel;

	private List<Item> list;

	@PostConstruct
	public void init() {
		createBarModels();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	public BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries items = new ChartSeries();
		// ChartSeries item = new ChartSeries();

		// for (Item i : list) {
		//
		// if (i.getAmount() == 1) {
		//
		// item.set(i.getAmount(), i.getPrice());
		// }
		// items.set(i.getAmount(), i.getPrice());
		//
		// }
		Map<Object, Number> map = new HashMap<>();
		for (Item i : list) {

			map.put(i.getAmount(), i.getPrice());

			items.setData(map);

		}

		// model.addSeries(item);
		model.addSeries(items);

		return model;
	}

	private void createBarModels() {
		createBarModel();
	}

	public void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Bar Chart");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Amount");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Price");
		yAxis.setMin(0);
		yAxis.setMax(1000);
	}

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

}