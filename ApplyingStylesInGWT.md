# Introduction #

GWT provides very few Java methods directly related to style. Rather, we encourage you to define styles in Cascading Style Sheets(CSS).
When it comes to styling web applications, CSS is ideal. In addition to cleanly separating style from application logic, this division
of labor helps applications load and render more quickly, consume less memory, and even makes them easier to tweak during edit/debug cycles
because there's no need to recompile for style tweaks.
  * a theme style sheet, standard.css: where the GWT default styles are defined (this can be changed in {appName}.gwt.xml)
  * the application style sheet, {appName}.css: where you define the specific styles for {appName}
  * other stylesheets

# Details #


In GWT, each class of widget has an associated style name (like gwt-Button) that binds it to a CSS style rule. This is the widget's primary style.
For example:
> HorizontalPanel addPanel = new HorizontalPanel();
results in html code:
> '<'table cellspacing="0" cellpadding="0" class="addPanel"> ...
-
**Setting primary style** for an HTML element:
  * widget.setStylePrimaryName("primaryStyle");
For example:
> HorizontalPanel addPanel = new HorizontalPanel();

> addPanel.setStylePrimaryName("primaryStyle");
results in html code:
> '<'table cellspacing="0" cellpadding="0" class="primaryStyle addPanel">...

**Adding secondary style** for an HTML element:
  * widget.addStyleName("secondaryStyle");
For example:
> HorizontalPanel addPanel = new HorizontalPanel();

> addPanel.setStylePrimaryName("primaryStyle");

> addPanel.addStyleName("styleName");

results in html code:
> '<'table cellspacing="0" cellpadding="0" class="primaryStyle styleName addPanel">...

**Adding dependent style to primary style** for an HTML element ( = getStylePrimaryName() + '-' + dependent):
  * widget.addStyleDependentName("dependent");
For example:
> HorizontalPanel addPanel = new HorizontalPanel();

> addPanel.setStylePrimaryName("primaryStyle");

> addPanel.addStyleName("styleName");

> addPanel.addStyleDependentName("dependent");

results in html code:
> '<'table cellspacing="0" cellpadding="0" class="primaryStyle styleName primaryStyle-dependent addPanel">...

**Setting style** for an HTML element ( Clears all of the object's style names(an associated style name (like gwt-Button)) and sets it to the given style):
  * widget.setStyleName("style");
For example:
> HorizontalPanel addPanel = new HorizontalPanel();

> addPanel.setStylePrimaryName("primaryStyle");

> addPanel.addStyleName("styleName");

> addPanel.addStyleDependentName("dependent");

> addPanel.setStyleName("style");
results in html code:
> '<'table cellspacing="0" cellpadding="0" class="style addPanel">...


---


**To set the id for a GWT widget, retrieve its DOM Element and then set the id attribute as follows:**

> Button b = new Button();
> DOM.setElementAttribute(b.getElement(), "id", "my-button-id")