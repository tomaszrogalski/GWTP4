package GWTP10.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(properties = {"gin.ginjector.modules"}, value = { MyGinModule.class })

public interface MyGinjector extends Ginjector {
}
