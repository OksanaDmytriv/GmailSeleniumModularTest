package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomConditions {

    /*public static ExpectedCondition<Boolean> textsOf(final By locator, final String... texts) {
        return new ExpectedCondition<Boolean>() {
            private List<String> currentTexts;
            private List<WebElement> elements;

            public Boolean apply(WebDriver webDriver) {
                elements = webDriver.findElements(locator);
                currentTexts = new ArrayList<String>();
                for (int i = 0; i < elements.size(); ++i) {
                    currentTexts.add(i, elements.get(i).getText());
                }
                if (currentTexts.size() != texts.length) {
                    return false;
                } else {
                    for (int i = 0; i < texts.length; ++i) {
                        if (!currentTexts.get(i).contains(texts[i])) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            public String toString() {
                return String.format("\ntext of list: \n should be: %s\n while actual text is: %s\n", Arrays.toString(texts), Arrays.toString(currentTexts.toArray()));
            }
        };
    }*/

    public static <V> V textsOf(final By locator, final String... texts) {
        return new <V> V () {
            private List<String> currentTexts;
            private List<WebElement> elements;

            public V apply(WebDriver webDriver) {
                elements = webDriver.findElements(locator);
                currentTexts = new ArrayList<String>();
                for (int i = 0; i < elements.size(); ++i) {
                    currentTexts.add(i, elements.get(i).getText());
                }
                if (currentTexts.size() != texts.length) {
                    return V;
                }
                else {
                    for (int i = 0; i < texts.length; ++i) {
                        if (!currentTexts.get(i).contains(texts[i])) {
                            return V;
                        }
                    }
                    return V;
                }
            }

            public String toString() {
                return String.format("\ntext of list: \n should be: %s\n while actual text is: %s\n", Arrays.toString(texts), Arrays.toString(currentTexts.toArray()));
            }
        };
    }

 /*   public static ExpectedCondition<Boolean> listNthElementHasText(final By locator,
                                                                   final int index, final String text) {
        return new ExpectedCondition<Boolean>() {
            private String currentText;
            private List<WebElement> elements;

            public Boolean apply(WebDriver webDriver) {
                try {
                    elements = webDriver.findElements(locator);
                    currentText = elements.get(index).getText();
                    return (currentText.contains(text)) ? true : false;
                } catch (IndexOutOfBoundsException ex) {
                    return null;
                }
            }

            public String toString() {
                return String.format("\ntext of element should be: %s\n while actual text is: %s\n", text, currentText);

            }
        };
    }*/

    public static <V> V listNthElementHasText(final By locator,
                                                                   final int index, final String text) {
        return new <V> V() {
            private String currentText;
            private List<WebElement> elements;

            public V apply(WebDriver webDriver) {
                try {
                    elements = webDriver.findElements(locator);
                    currentText = elements.get(index).getText();
                    if ((currentText.contains(text)) ? true : false) {
                        return V;
                    }
                    else return null;
                } catch (IndexOutOfBoundsException ex) {
                    return null;
                }
            }

            public String toString() {
                return String.format("\ntext of element should be: %s\n while actual text is: %s\n", text, currentText);

            }
        };
    }

    /*public static ExpectedCondition<Boolean> sizeOf(final By elementsLocator, final int expectedSize) {
        return new ExpectedCondition<Boolean>() {
            private int listSize;
            private List<WebElement> results;

            public Boolean apply(WebDriver webDriver) {
                results = webDriver.findElements(elementsLocator);
                listSize = results.size();
                return listSize == expectedSize;
            }

            public String toString() {
                return String.format("\nsize of list: %s\n should be: %s\n while actual size is: %s\n", results, expectedSize, listSize);

            }
        };
    }*/

    public static <V> V sizeOf(final By elementsLocator, final int expectedSize) {
        return new <V> V() {
            private int listSize;
            private List<WebElement> results;

            public V apply(WebDriver webDriver) {
                results = webDriver.findElements(elementsLocator);
                listSize = results.size();
                if (listSize == expectedSize) {
                    return V;
                }
                else return null;

            }

            public String toString() {
                return String.format("\nsize of list: %s\n should be: %s\n while actual size is: %s\n", results, expectedSize, listSize);

            }
        };
    }

    /*public static ExpectedCondition<Boolean> minimumSizeOf(final By elementsLocator, final int minimumSize) {
        return new ExpectedCondition<Boolean>() {
            private int listSize;
            private List<WebElement> results;

            public Boolean apply(WebDriver webDriver) {
                results = webDriver.findElements(elementsLocator);
                listSize = results.size();
                return listSize >= minimumSize;
            }

            public String toString() {
                return String.format("\nsize of list: %s\n minimum size should be: %s\n while actual size is: %s\n", results, minimumSize, listSize);

            }
        };
    }*/

    public static <V> V minimumSizeOf(final By elementsLocator, final int minimumSize) {
        return new <V> V() {
            private int listSize;
            private List<WebElement> results;

            public V apply(WebDriver webDriver) {
                results = webDriver.findElements(elementsLocator);
                listSize = results.size();
                if (listSize >= minimumSize) {
                    return V;
                }
                else return null;
            }

            public String toString() {
                return String.format("\nsize of list: %s\n minimum size should be: %s\n while actual size is: %s\n", results, minimumSize, listSize);

            }
        };
    }
}
