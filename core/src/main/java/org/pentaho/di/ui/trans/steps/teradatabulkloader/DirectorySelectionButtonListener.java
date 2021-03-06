/*******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2017 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.di.ui.trans.steps.teradatabulkloader;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.pentaho.di.ui.core.widget.TextVar;

/**
 * The listener interface for receiving directorySelectionButton events. The class that is interested in processing a
 * directorySelectionButton event implements this interface, and the object created with that class is registered with a
 * component using the component's <code>addDirectorySelectionButtonListener<code> method. When
 * the directorySelectionButton event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see DirectorySelectionButtonEvent
 */
class DirectorySelectionButtonListener extends SelectionAdapter {
  private final Shell shell;
  /** The text widget. */
  private final TextVar textWidget;

  /**
   * Instantiates a new directory selection button listener.
   * 
   * @param textWidget
   *          the text widget
   * @param teraDataBulkLoaderDialog
   *          TODO
   */
  DirectorySelectionButtonListener( TextVar textWidget, Shell shell ) {
    this.textWidget = textWidget;
    this.shell = shell;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
   */
  @Override
  public void widgetSelected( SelectionEvent e ) {
    DirectoryDialog dialog = new DirectoryDialog( shell, SWT.OPEN );
    if ( dialog.open() != null ) {
      String str = dialog.getFilterPath() + System.getProperty( "file.separator" ) + dialog.getText();
      this.textWidget.setText( str );
    }
  }
}
