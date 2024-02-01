package pages;

import annotations.Component;
import com.google.inject.Inject;
import utils.DIScope;

@Component("//h2[contains(text(),'Авторские онлайн‑курсы')]")
public class MainPage extends AbsBasePage<MainPage> {


  private final DIScope diScope;


  @Inject
  public MainPage(DIScope diScope) {
    super(diScope);
    this.diScope = diScope;
  }

}
