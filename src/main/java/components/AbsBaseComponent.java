package components;

import com.google.inject.Inject;
import utils.AbsBaseUtils;
import utils.DIScope;

public class AbsBaseComponent extends AbsBaseUtils {


  @Inject
  public AbsBaseComponent(DIScope diScope) {
    super(diScope);
  }

}
