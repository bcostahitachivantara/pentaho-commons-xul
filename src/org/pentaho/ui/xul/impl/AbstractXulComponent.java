/**
 * 
 */
package org.pentaho.ui.xul.impl;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;

import org.pentaho.ui.xul.XulComponent;
import org.pentaho.ui.xul.XulException;
import org.pentaho.ui.xul.dom.Attribute;
import org.pentaho.ui.xul.dom.Document;
import org.pentaho.ui.xul.dom.DocumentFactory;
import org.pentaho.ui.xul.dom.Element;
import org.pentaho.ui.xul.dom.Namespace;

/**
 * @author OEM
 *
 */
public abstract class AbstractXulComponent implements XulComponent {
  private static final long serialVersionUID = -3629792827245143824L;

  protected Object managedObject;

  protected Element element;

  protected int flex = 0;

  protected String id;

  protected boolean flexLayout = false;

  // TODO: This should be moved out to a Swing specific subclass of xulelement
  protected GridBagConstraints gc;

  protected List<XulComponent> children;

  public AbstractXulComponent(Element element) {
    this.element = element;
    children = new ArrayList<XulComponent>();

  }

  public AbstractXulComponent(String name) {
    try {
      this.element = DocumentFactory.createElement(name, this);
      children = new ArrayList<XulComponent>();
    } catch (XulException e) {
      //TODO: add logging and perhaps throw illegalArgumentException or rethrow XulEx.
      System.out.println(String.format("error creating XulElement (%s)", name));
    }
  }

  public AbstractXulComponent(String tagName, Object managedObject) {
    try {
      this.element = DocumentFactory.createElement(tagName, this);
      this.managedObject = managedObject;
      children = new ArrayList<XulComponent>();
    } catch (XulException e) {
      //TODO: add logging and perhaps throw illegalArgumentException or rethrow XulEx.
      System.out.println(String.format("error creating XulElement (%s)", tagName));
    }
  }

  public Object getManagedObject() {
    return managedObject;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.setAttribute("ID", id);
    this.id = id;
  }

  public int getFlex() {
    return flex;
  }

  public void setFlex(int flex) {
    this.flex = flex;
  }

  public void addComponent(XulComponent c) {
    children.add(c);
  }

  public void layout() {

  }

  //passthrough DOM methods below
  //TODO: extract methods below into abstract class
  public String getName() {
    return element.getName();
  }

  public void addChild(Element ele) {
    this.element.addChild(ele);

  }

  public void removeChild(Element ele) {
    this.element.removeChild(ele);

  }

  public List<XulComponent> getChildNodes() {
    return this.element.getChildNodes();
  }

  public Document getDocument() {
    return this.element.getDocument();
  }

  public XulComponent getElementById(String elementId) {
    return this.element.getElementById(elementId);
  }

  public XulComponent getElementByXPath(String path) {
    return this.element.getElementByXPath(path);
  }

  public Object getElementObject() {
    return this.element.getElementObject();
  }

  public List<XulComponent> getElementsByTagName(String tagName) {
    return this.element.getElementsByTagName(tagName);
  }

  public XulComponent getFirstChild() {
    return this.element.getFirstChild();
  }

  public Namespace getNamespace() {
    return this.element.getNamespace();
  }

  public XulComponent getParent() {
    return this.element.getParent();
  }

  public String getText() {
    return this.element.getText();
  }

  public void setAttribute(Attribute attribute) {
    this.element.setAttribute(attribute);
  }

  public void setNamespace(String prefix, String uri) {
    this.element.setNamespace(prefix, uri);

  }

  public List<Attribute> getAttributes() {
    return this.element.getAttributes();
  }

  public String getAttributeValue(String attributeName) {
    return this.element.getAttributeValue(attributeName);
  }

  public void setAttributes(List<Attribute> attributes) {
    this.element.setAttributes(attributes);
  }

  public void setAttribute(String name, String value) {
    this.element.setAttribute(name, value);
  }

  public AbstractXulComponent getXulElement() {
    return this;
  }

  public void replaceChild(XulComponent oldElement, XulComponent newElement){
    this.element.replaceChild(oldElement, newElement);
  }
  
}
