package com.ruisi.vdop.ser.bireport;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ruisi.ext.engine.cross.OlapWriterInterface;
import com.ruisi.ext.engine.view.context.cross.CrossReportContext;
import com.ruisi.ext.engine.wrapper.ExtRequest;
import com.ruisi.ext.engine.wrapper.ExtWriter;

public class UserDefinedOlapWriter implements OlapWriterInterface {
	
	private JSONObject tablej;
	private JSONArray kpij;
	
	private String compareDate(String str1, String str2){
		int s1 = Integer.parseInt(str1);
		int s2 = Integer.parseInt(str2);
		if(s1 > s2){
			
		}else if(s1 < s2){
			
		}else{
			
		}
		return "";
	}

	@Override
	public void wirteRowDims(ExtRequest request, ExtWriter out, CrossReportContext report) {
		tablej = (JSONObject)request.getAttribute("tablej");
		kpij = (JSONArray)request.getAttribute("kpij");
		
		out.print("<div class='rowDimsList'>");
		
		JSONArray array = tablej.getJSONArray("rows");
		for(int i=0; i<array.size(); i++){
			JSONObject obj = array.getJSONObject(i);
			String id = obj.getString("id");
			String name = obj.getString("dimdesc");
			out.print("<span>"+name+" <a href=javascript:; onclick='setRdimInfo(this, \""+id+"\", \""+ name +"\")' class='dimoptbtn set'> &nbsp; </a></span>");
		}
		out.println("</div>");
	}

	@Override
	public void writeColDims(ExtRequest request, ExtWriter out, CrossReportContext report) {
		tablej = (JSONObject)request.getAttribute("tablej");
		kpij = (JSONArray)request.getAttribute("kpij");

		out.print("<div class='colDimsList'>");
		
		JSONArray array = tablej.getJSONArray("cols");
		if(array.size() <= 1){
			out.print(" <div style=\"margin:3px;color:#999999;font-size:13px;\">列标签区域</div> ");
		}else{
			for(int i=0; i<array.size() - 1; i++){
				JSONObject obj = array.getJSONObject(i);
				String id = obj.getString("id");
				String name = obj.getString("dimdesc");
				out.print("<span>"+name+" <a href=javascript:; onclick='setCdimInfo(this, \""+id+"\", \""+name+"\")' class='dimoptbtn set'> &nbsp; </a></span>");
			}
		}
		
		out.println("</div>");
	}

}
