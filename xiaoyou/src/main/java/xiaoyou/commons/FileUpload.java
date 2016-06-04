package xiaoyou.commons;

import java.util.Map;

import javax.servlet.jsp.PageContext;

public class FileUpload {
	private static final String ALLOWED="gif,png,jpg,jpeg";//鍏佽涓婁紶鐨勬枃浠�
	private static final String DENTED="html,jsp.exe,bat,com";//涓嶅厑璁镐笂浼犵殑鏂囦欢绫诲瀷
	private static final int TOTALFILE=20*1024*1024;//鏂囦欢鎬诲ぇ灏�
	private static final int SINGLEFILESIZE=1024*1024;//鍗曚釜鏂囦欢澶у皬
	private static final String PATH="upload/";//淇濆瓨鍥剧墖鐨勮矾寰�
	
	public Map<String, String>  upload(PageContext  context) throws Exception{
		return null;
	/*	Map<String,String> map = new HashMap<String, String>();
		SmartUpload  upload = new SmartUpload();
		//鍒濆鍖�
		upload.initialize(context);
		//鍙傛暟杩涜璁剧疆
		upload.setAllowedFilesList(ALLOWED);
		upload.setDeniedFilesList(DENTED);
		upload.setCharset("UTF-8");
		upload.setMaxFileSize(SINGLEFILESIZE);
		upload.setTotalMaxFileSize(TOTALFILE);
		upload.upload();//寮�濮嬫帴鏀朵笂浼�
		Request request =upload.getRequest();//鍔熻兘绛夊悓浜嶫sp椤甸潰涓婄殑request
		//鑾峰彇璇锋眰涓殑鍙傛暟
		//String user_id=request.getParameter("user_id");
		//鑾峰彇鎵�鏈夎〃鍗曞厓绱犵殑name灞炴�у��
		Enumeration<String> enums =request.getParameterNames(); 
		String fieldName;
		while(enums.hasMoreElements()){
			fieldName =enums.nextElement();
			System.out.println(fieldName);
			map.put(fieldName, request.getParameter(fieldName));
		}
		
		Files files =upload.getFiles();
		if(null!=files&&files.getCount()>0){//鏂囦欢瀛樺湪
			Collection<File> fs =files.getCollection();
			String realPath="";
			StringBuffer  sb =new StringBuffer();
			for(File file:fs){
				if(!file.isMissing()){//鏂囦欢鏁版嵁鏄惁涓㈠け
					System.out.println(file.getFileName());
					realPath =PATH+System.currentTimeMillis()+new Random().nextInt(1000)+"."+file.getFileExt();
					System.out.println(realPath);
					//淇濆瓨鍒版湇鍔″櫒涓�
					file.saveAs(realPath,SmartUpload.SAVE_VIRTUAL);//鍙﹀瓨   1.GIF ,  2.gif ,  
					sb.append(realPath).append(",");
					System.out.println(sb.toString());
				}
			}
			String image =sb.toString();
			if(null!=image&&!"".equals(image)){
				System.out.println("0--------------------------"+image);
				map.put("image", image);
			}
		}
		return map;*/
	}
	
	

}
