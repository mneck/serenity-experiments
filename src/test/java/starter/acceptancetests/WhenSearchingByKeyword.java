package starter.acceptancetests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import net.serenitybdd.annotations.Managed;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import starter.duckduckgo.NavigateActions;
import starter.duckduckgo.SearchActions;
import starter.duckduckgo.SearchResultSidebar;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SerenityJUnit5Extension.class)
class WhenSearchingByKeyword {

    @Managed(driver = "chrome", options = "headless")
    WebDriver driver;

    NavigateActions navigate;
    SearchActions search;
    SearchResultSidebar searchResultSidebar;

    @Test
    @DisplayName("Should be able to search for cats")
    void theKeywordShouldAppearInTheResultsSidebar() {
        navigate.toTheDuckDuckGoSearchPage();
        search.byKeyword("Cats");
        Serenity.reportThat("The keyword should appear in the sidebar heading",
                () -> assertThat(searchResultSidebar.heading()).isEqualTo("Cats")
        );
    }
}
