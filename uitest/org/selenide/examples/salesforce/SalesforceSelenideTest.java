package org.selenide.examples.salesforce;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SalesforceSelenideTest {
  @Test
  public void contactsPage() {
    login();
    $(".mainTitle").shouldHave(text("Contacts"));
    $(".pbBody table.list thead").shouldHave(text("Name"), text("Email"), text("Account Name"));
    $$(".pbBody table.list tbody tr").shouldHave(size(20));
    $(".pbBody table.list tbody tr").shouldHave(text("Rose Gonzalez"), text("rose@edge.com"), text("Edge Communications"));
  }

  private void login() {
    String username = System.getProperty("salesforce.username", "please configure salesforce username");
    String password = System.getProperty("salesforce.password", "please configure salesforce password");

    open("https://c.eu5.visual.force.com/apex/hello_page");
    $("#username").val(username);
    $("#password").val(password).pressEnter();

    SelenideElement notification = $(byText("Scheduled Maintenance Notification"));
    if (notification.is(visible)) {
      notification.closest("div").find(byText("Continue")).click();
    }
  }
}
