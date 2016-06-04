package xiaoyou.biz;

import java.util.List;

import xiaoyou.po.photoPO;

public interface IBack_photoBiz {
		public boolean noPhoto(photoPO po);
		public boolean okPhoto(photoPO po);
		//上传照片信息查找分页
		public List<photoPO> findByPage(Integer pageNo,Integer pageSize);
		
		public int getCount();
}
