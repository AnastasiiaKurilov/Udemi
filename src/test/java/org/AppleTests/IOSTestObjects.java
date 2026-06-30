package org.AppleTests;

import org.Base.BaseTestsIOS;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.AppleTests.Apple.AllertViewsPage;

public class IOSTestObjects extends BaseTestsIOS {
    @Test
    public void IOSTest(){
///Steps: In app Alert Views—> Text Entry→ type your name → click OK and it closed —> select Confirm /Cancel —> In pop up retrieve message and add assertion→Click Confirm

  /// IOS Locators :AccesabitlityID, id, IOS class chain ,IOS predicate String

        AllertViewsPage allertpage= homePage.setAllertView();
         allertpage.fillText("Anastasiia");
      String allertMessegeString= allertpage.getConfirmMessege();
      Assert.assertEquals(allertMessegeString,"A message should be a short, complete sentence.");

    }
}
