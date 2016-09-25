package com.tgb.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tgb.entity.OriFile;
import com.tgb.manager.OriFileManager;

@Controller
@RequestMapping("/OriFile")
public class OriFileController {
	
	@Resource(name="oriFileManager")
	private OriFileManager oriFileManager;
	
	@Resource(name="oriFile")
	private OriFile oriFile;
	
	@RequestMapping("/getOriFile")
	public String getOriFile(String id,HttpServletResponse response){
//		request.setAttribute("oriFile", oriFileManager.getOriFile(id));
		String result = "{\"result\":\"error\"}";
		OriFile oriFile = oriFileManager.getOriFile(id);
		System.out.println(oriFile.getOrifileName());
		if(oriFile!=null){
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping("/getAllOriFile")
	@ResponseBody
	public String getAllUser(HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
//		request.setAttribute("oriFileList", oriFileManager.getAllOriFile());
//		Object ob = request.getAttribute("oriFileList");
//		List<OriFile> listFiles = (List<OriFile>)ob;
//		for(int i=0;i<listFiles.size();i++){
//			System.out.println("oriFileID: " + listFiles.get(i).getEventLog());
//		}
		
//		//从数据库获取所有原始日志文件，List<OriFile>
//		List<OriFile> listFiles = oriFileManager.getAllOriFile();
//		//将List<OriFile>格式转换为json格式
//		JSONArray json = new JSONArray();
//		for(int i=0;i<listFiles.size();i++){
//            JSONObject jo = new JSONObject();
//            jo.put("id", listFiles.get(i).getId());
//            jo.put("orifileName", listFiles.get(i).getOrifileName());
//            jo.put("format", listFiles.get(i).getFormat());
//            jo.put("eventLog", listFiles.get(i).getEventLog());
//            jo.put("creationDate", listFiles.get(i).getCreationDate());
//            jo.put("creationBy", listFiles.get(i).getCreationBy());
//            json.add(jo);
//        }
//		request.setAttribute("oriFileList", json);
//		System.out.println(json.toString());
		
		//从数据库获取所有原始日志文件:List<OriFile>,然后将List<OriFile>格式转换为json格式到前端页面以dataGrid进行展示
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map=new HashMap<String, Object>();
		List<OriFile> list = oriFileManager.getAllOriFile();
		map.put("rows",list);
		map.put("total",list.size());
		return mapper.writeValueAsString(map);
//		return "/home";
	}
	
	@RequestMapping("/serchOriFile")
	public String serchOriFile(String content, HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map=new HashMap<String, Object>();
		List<OriFile> list = oriFileManager.searchAllOriFile(content);
		map.put("rows",list);
		map.put("total",list.size());
		return mapper.writeValueAsString(map);
	}
	
	@RequestMapping("/delOriFile")
	public void delOriFile(String id,HttpServletResponse response){
		String result = "{\"result\":\"error\"}";
		if(oriFileManager.delOriFile(id)){
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/toAddOriFile")
	public String toAddOriFile(){
		return "/addOriFile";
	}
	
	
	@RequestMapping("/addOriFile")
	public String addOriFile(String path, HttpServletRequest request) throws UnsupportedEncodingException{
		String str = path;
		String inputer = new String( str.getBytes("ISO-8859-1"),"utf-8");
//		System.out.println(inputer);
		String[] strs = str.split("\\\\");
		String oriFileName = strs[strs.length-1];
		
//		for(String name:strs){
//		     System.out.println(name);
//		}
//		oriFileManager.addOriFile(oriFile);
		return "redirect:/oriFile/getAllOriFile";
	}
//	@RequestMapping("/addOriFile")
//	public String addOriFile(OriFile oriFile, HttpServletRequest request){
//		oriFileManager.addOriFile(oriFile);
//		return "redirect:/oriFile/getAllOriFile";
//	}
	
	@RequestMapping("/updateOriFile")
	public String updateOriFile(OriFile oriFile, HttpServletRequest request){
		if(oriFileManager.updateOriFile(oriFile)){
			oriFile = oriFileManager.getOriFile(oriFile.getId());
			request.setAttribute("oriFile", oriFile);
			return "redirect:/oriFile/getAllOriFile";
		}else{
			return "/error";
		}
	}

}
