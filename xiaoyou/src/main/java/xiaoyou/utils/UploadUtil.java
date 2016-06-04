package xiaoyou.utils;

import java.util.Map;

import javax.servlet.jsp.PageContext;

public class UploadUtil {

	public static String PATH="../upload";
	private static final String ALLOWED="gif,jpg,png,jpeg";
	private static final String DENIEO="exe,bat,jsp,html";
	private static final int TOTALMAXSIZE=20*1024*1024;
	private static final int  SINGLEFILESIZE=1024*1024;
	
	public static Map<String ,String > upload(PageContext context) throws Exception{
		return null;
		/*Map<String,String> map=new HashMap<String,String>();
		SmartUpload su=new SmartUpload();
		su.initialize(context);
		
		su.setAllowedFilesList(ALLOWED);
		su.setDeniedFilesList(DENIEO);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setMaxFileSize(SINGLEFILESIZE);
		su.setCharset("utf-8");
		
		su.upload();
		
		Request request=su.getRequest();
		@SuppressWarnings("rawtypes")
		Enumeration enums=request.getParameterNames();
		
		String str;
		while(enums.hasMoreElements()){
			str= (String) enums.nextElement();
			map.put(str,request.getParameter(str));
		}
		
		Files fs=su.getFiles();
		if(fs!=null && fs.getCount()>0){
			@SuppressWarnings("unchecked")
			Collection<File> files=fs.getCollection();
			String fileName;
			String path="";
			for(File fl:files){
				if(!fl.isMissing()){
					fileName=PATH+"/"+new Date().getTime()+""+new Random().nextInt(1000)+"."+fl.getFileExt();
					System.out.println(PATH+"/"+new Date().getTime()+""+new Random().nextInt(1000)+"."+fl.getFileExt());
					fl.saveAs(fileName);
					path+=fileName+",";
				}
			}
			if("".equals(path)){
				map.put("photo", "");
			}else{
				map.put("photo", path.substring(0,path.lastIndexOf(",")));
			}
		}
		//System.out.println(PATH+"-------------------------");
		return map;*/
	}
	
}
