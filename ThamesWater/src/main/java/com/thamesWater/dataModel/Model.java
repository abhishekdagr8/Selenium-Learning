package com.thamesWater.dataModel;

import java.util.List;
import com.thamesWater.dataObject.DTO;


public interface Model {

		public <T extends DTO>  T get(String rownname);
		public <T extends DTO>  List<T> getList(String rownname);

}
