/**
 * generated by Xtext 2.9.1
 */
package org.xtuml.bp.ui.xtext.myDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtuml.bp.ui.xtext.myDsl.MyDslPackage;
import org.xtuml.bp.ui.xtext.myDsl.domainFunctionDefinition;
import org.xtuml.bp.ui.xtext.myDsl.returnType;
import org.xtuml.bp.ui.xtext.myDsl.serviceVisibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>domain Function Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtuml.bp.ui.xtext.myDsl.impl.domainFunctionDefinitionImpl#getS <em>S</em>}</li>
 *   <li>{@link org.xtuml.bp.ui.xtext.myDsl.impl.domainFunctionDefinitionImpl#getR <em>R</em>}</li>
 * </ul>
 *
 * @generated
 */
public class domainFunctionDefinitionImpl extends definitionImpl implements domainFunctionDefinition
{
  /**
   * The cached value of the '{@link #getS() <em>S</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getS()
   * @generated
   * @ordered
   */
  protected serviceVisibility s;

  /**
   * The cached value of the '{@link #getR() <em>R</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getR()
   * @generated
   * @ordered
   */
  protected returnType r;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected domainFunctionDefinitionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MyDslPackage.Literals.DOMAIN_FUNCTION_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public serviceVisibility getS()
  {
    return s;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetS(serviceVisibility newS, NotificationChain msgs)
  {
    serviceVisibility oldS = s;
    s = newS;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.DOMAIN_FUNCTION_DEFINITION__S, oldS, newS);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setS(serviceVisibility newS)
  {
    if (newS != s)
    {
      NotificationChain msgs = null;
      if (s != null)
        msgs = ((InternalEObject)s).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.DOMAIN_FUNCTION_DEFINITION__S, null, msgs);
      if (newS != null)
        msgs = ((InternalEObject)newS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.DOMAIN_FUNCTION_DEFINITION__S, null, msgs);
      msgs = basicSetS(newS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.DOMAIN_FUNCTION_DEFINITION__S, newS, newS));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public returnType getR()
  {
    return r;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetR(returnType newR, NotificationChain msgs)
  {
    returnType oldR = r;
    r = newR;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.DOMAIN_FUNCTION_DEFINITION__R, oldR, newR);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setR(returnType newR)
  {
    if (newR != r)
    {
      NotificationChain msgs = null;
      if (r != null)
        msgs = ((InternalEObject)r).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.DOMAIN_FUNCTION_DEFINITION__R, null, msgs);
      if (newR != null)
        msgs = ((InternalEObject)newR).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.DOMAIN_FUNCTION_DEFINITION__R, null, msgs);
      msgs = basicSetR(newR, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.DOMAIN_FUNCTION_DEFINITION__R, newR, newR));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MyDslPackage.DOMAIN_FUNCTION_DEFINITION__S:
        return basicSetS(null, msgs);
      case MyDslPackage.DOMAIN_FUNCTION_DEFINITION__R:
        return basicSetR(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MyDslPackage.DOMAIN_FUNCTION_DEFINITION__S:
        return getS();
      case MyDslPackage.DOMAIN_FUNCTION_DEFINITION__R:
        return getR();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.DOMAIN_FUNCTION_DEFINITION__S:
        setS((serviceVisibility)newValue);
        return;
      case MyDslPackage.DOMAIN_FUNCTION_DEFINITION__R:
        setR((returnType)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.DOMAIN_FUNCTION_DEFINITION__S:
        setS((serviceVisibility)null);
        return;
      case MyDslPackage.DOMAIN_FUNCTION_DEFINITION__R:
        setR((returnType)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.DOMAIN_FUNCTION_DEFINITION__S:
        return s != null;
      case MyDslPackage.DOMAIN_FUNCTION_DEFINITION__R:
        return r != null;
    }
    return super.eIsSet(featureID);
  }

} //domainFunctionDefinitionImpl
