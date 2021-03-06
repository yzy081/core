//-----BEGIN DISCLAIMER-----
/*******************************************************************************
* Copyright (c) 2017 JCrypTool Team and Contributors
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
//-----END DISCLAIMER-----
package org.jcryptool.crypto.flexiprovider.algorithms.ui.dynamic.composites;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jcryptool.crypto.flexiprovider.algorithms.ui.dynamic.IAlgorithmParameterInputArea;

public class StringInputArea implements IAlgorithmParameterInputArea {

	private Text valueText;

	public StringInputArea(Composite parent, String description) {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		Label descriptionLabel = new Label(parent, SWT.NONE);
        descriptionLabel.setText(NLS.bind(Messages.StringInputArea_0, description));
		descriptionLabel.setLayoutData(gridData);

		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.BEGINNING;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.widthHint = 150;
		gridData1.verticalAlignment = GridData.CENTER;
		valueText = new Text(parent, SWT.BORDER);
		valueText.setLayoutData(gridData1);
		valueText.addVerifyListener(new VerifyListener() {

			public void verifyText(VerifyEvent e) {
				if (e.character != SWT.BS && e.character != SWT.DEL) {
					if (page != null) {
						page.setPageComplete(true);
					}
				}
			}

		});

		parent.setLayout(new GridLayout());

		Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData separatorGridData = new GridData();
		separatorGridData.horizontalAlignment = GridData.FILL;
		separatorGridData.grabExcessHorizontalSpace = true;
		separator.setLayoutData(separatorGridData);
	}

	public Object getValue() {
		if (valueText != null) {
			return valueText.getText();
		} else {
			return null;
		}
	}

	public void setValue(Object value) {
		// unused
	}

	private WizardPage page;

	public void setWizardPage(WizardPage page) {
		this.page = page;
	}

}
