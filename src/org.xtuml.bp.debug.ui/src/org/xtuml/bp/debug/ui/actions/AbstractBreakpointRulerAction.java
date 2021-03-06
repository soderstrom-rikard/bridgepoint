//========================================================================
//
//File:      $RCSfile$
//Version:   $Revision$
//Modified:  $Date$
//
//(c) Copyright 2006-2014 by Mentor Graphics Corp. All rights reserved.
//
//========================================================================
// Licensed under the Apache License, Version 2.0 (the "License"); you may not 
// use this file except in compliance with the License.  You may obtain a copy 
// of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   See the 
// License for the specific language governing permissions and limitations under
// the License.
//======================================================================== 
//
package org.xtuml.bp.debug.ui.actions;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.AbstractMarkerAnnotationModel;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.IUpdate;

import org.xtuml.bp.debug.ui.BPDebugUIPlugin;
import org.xtuml.bp.debug.ui.model.BPLineBreakpoint;

public abstract class AbstractBreakpointRulerAction extends Action implements IUpdate {

	private IVerticalRulerInfo fInfo;

	private ITextEditor fTextEditor;

	private IBreakpoint fBreakpoint;

	protected IBreakpoint determineBreakpoint() {
		IBreakpoint[] breakpoints= DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(BPDebugUIPlugin.getUniqueIdentifier());
		for (int i= 0; i < breakpoints.length; i++) {
			IBreakpoint breakpoint= breakpoints[i];
			if (breakpoint instanceof BPLineBreakpoint) {
				BPLineBreakpoint jBreakpoint= (BPLineBreakpoint)breakpoint;
				try {
					if (breakpointAtRulerLine(jBreakpoint)) {
						return jBreakpoint;
					}
				} catch (CoreException ce) {
					BPDebugUIPlugin.logError("Error locating breakpoint", ce);
					continue;
				}
			}
		}
		return null;
	}

	protected IVerticalRulerInfo getInfo() {
		return fInfo;
	}

	protected void setInfo(IVerticalRulerInfo info) {
		fInfo = info;
	}

	protected ITextEditor getTextEditor() {
		return fTextEditor;
	}

	protected void setTextEditor(ITextEditor textEditor) {
		fTextEditor = textEditor;
	}

	/** 
	 * Returns the resource for which to create the marker, 
	 * or <code>null</code> if there is no applicable resource.
	 *
	 * @return the resource for which to create the marker or <code>null</code>
	 */
	protected IResource getResource() {
		IEditorInput input= fTextEditor.getEditorInput();
		IResource resource= (IResource) input.getAdapter(IFile.class);
		if (resource == null) {
			resource= (IResource) input.getAdapter(IResource.class);
		}	
		return resource;
	}

	protected boolean breakpointAtRulerLine(BPLineBreakpoint jBreakpoint) throws CoreException {
		AbstractMarkerAnnotationModel model = getAnnotationModel();
		if (model != null) {
			Position position= model.getMarkerPosition(jBreakpoint.getMarker());
			if (position != null) {
				IDocumentProvider provider= getTextEditor().getDocumentProvider();
				IDocument doc=  provider.getDocument(getTextEditor().getEditorInput());
				try {
					int markerLineNumber= doc.getLineOfOffset(position.getOffset());
					int rulerLine= getInfo().getLineOfLastMouseButtonActivity();
					if (rulerLine == markerLineNumber) {
						if (getTextEditor().isDirty()) {
							return jBreakpoint.getLineNumber() == markerLineNumber + 1;
						}
						return true;
					}
				} catch (BadLocationException x) {
				}
			}
		}
		
		return false;
	}
		
	protected IBreakpoint getBreakpoint() {
		return fBreakpoint;
	}

	protected void setBreakpoint(IBreakpoint breakpoint) {
		fBreakpoint = breakpoint;
	}
	
	/**
	 * Returns the <code>AbstractMarkerAnnotationModel</code> of the editor's input.
	 *
	 * @return the marker annotation model
	 */
	private AbstractMarkerAnnotationModel getAnnotationModel() {
		IDocumentProvider provider= fTextEditor.getDocumentProvider();
		IAnnotationModel model= provider.getAnnotationModel(getTextEditor().getEditorInput());
		if (model instanceof AbstractMarkerAnnotationModel) {
			return (AbstractMarkerAnnotationModel) model;
		}
		return null;
	}
}
