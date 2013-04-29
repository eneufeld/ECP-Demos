package com.eclipsesource.accounting.internal.ui.e3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.eclipsesource.accounting.Invoice;
import com.eclipsesource.accounting.InvoiceState;
import com.eclipsesource.accounting.Order;
import com.eclipsesource.accounting.Project;

public class ProjectTurnoverView {

	public ProjectTurnoverView(){
	}
	private SimpleDateFormat sdf=new SimpleDateFormat("MMMMM");
	public void createContent(Composite parent, Project project){
		Map<Integer,MonthlyTurnover> turnoverperMonths=getTurnOverByMonth(project);
		Composite composite=new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(true).applyTo(composite);
		for(MonthlyTurnover invoice:turnoverperMonths.values()){
			
			String month="";
			if(invoice.month==-1)
				month="InvoiceDate not set";
			else{
				Calendar calendar=Calendar.getInstance();
				calendar.set(calendar.get(Calendar.YEAR), invoice.month, 1);
				month+=sdf.format(calendar.getTime());
			}
			
			
			
			Label monthLabel=new Label(composite, SWT.NONE);
			monthLabel.setText(month);
			
			Label amountLabel=new Label(composite, SWT.NONE);
			amountLabel.setText(""+invoice.value);
			
			Label paidLabel=new Label(composite, SWT.NONE);
			paidLabel.setText(invoice.paid?"Paid":"Unpaid");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	private Map<Integer,MonthlyTurnover> getTurnOverByMonth(Project project) {
		Map<Integer,MonthlyTurnover> result=new TreeMap<>();
		for(Order order:project.getOrders()){
			for(Invoice invoice:order.getInvoices()){
				int month=-1;
				if(invoice.getInvoiceDate()!=null)
					month=invoice.getInvoiceDate().getMonth();
				if(!result.containsKey(month)) {
					result.put(month,new MonthlyTurnover(month,invoice.getUnitAmount()*invoice.getOrder().getPricePerUnit(),invoice.getState()==InvoiceState.PAID));
				}
				else{
					MonthlyTurnover turnover=result.get(month);
					turnover.paid&=invoice.getState()==InvoiceState.PAID;
					turnover.value+=invoice.getUnitAmount()*invoice.getOrder().getPricePerUnit();
				}
			}
		}
		return result;
	}

	public void focus(){
		
	}
	
	public void dispose(){
		
	}
	
	private class MonthlyTurnover{
		private int month;
		private double value;
		private boolean paid;
		public MonthlyTurnover(int month, double value, boolean paid) {
			super();
			this.month = month;
			this.value = value;
			this.paid = paid;
		}
		
	}
}
