//################################################################################
//	The MIT License
//
//	Copyright (c) 2014 Johannes Raida
//
//	Permission is hereby granted, free of charge, to any person obtaining a copy
//	of this software and associated documentation files (the "Software"), to deal
//	in the Software without restriction, including without limitation the rights
//	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//	copies of the Software, and to permit persons to whom the Software is
//	furnished to do so, subject to the following conditions:
//
//	The above copyright notice and this permission notice shall be included in
//	all copies or substantial portions of the Software.
//
//	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//	THE SOFTWARE.
//################################################################################

package de.raida.jcadlib.cadimport.jt.model;

import java.util.List;

import de.raida.jcadlib.cadimport.jt.codec.Int32CDP2;
import de.raida.jcadlib.cadimport.jt.codec.PredictorType;
import de.raida.jcadlib.cadimport.jt.reader.UnsupportedCodecException;
import de.raida.jcadlib.cadimport.jt.reader.WorkingContext;

/**
 * <h>8.1.16.1 Compressed CAD Tag Type-1 Data</h>
 * Object Type ID: <code>---</code>
 * <br>Compressed CAD Tag Type-1 Data collection contains the Type-1 (i.e.
 * 64 Bit integer Type) CAD Tag data for a list of CAD Tags.
 * <br>The Compressed CAD Tag Type-1 Data collection is only present if there
 * are Type-1 CAD Tags in the CAD Tag Types vector. Thus a loader/reader of
 * JT file must first uncompress/decode and evaluate the previously read CAD
 * Tag Types vector to determine if there are any Type-1 CAD Tags and if so,
 * then the Compressed CAD Tag Type-1 Data collection is present.
 * <br>(c) 2014 by <a href="mailto:j.raida@gmx.net">Johannes Raida</a>
 * @author  <a href="mailto:j.raida@gmx.net">Johannes Raida</a>
 * @version 1.0
 */
public class CompressedCADTagType1Data {
	/**
	 * Constructor.
	 * @param firstI32OfType1CADTags  First I32 of type 1 CAD tags
	 * @param secondI32OfType1CADTags Second I32 of type 1 CAD tags
	 */
	public CompressedCADTagType1Data(List<Integer> firstI32OfType1CADTags, List<Integer> secondI32OfType1CADTags){
	}

	/**
	 * Reads a CompressedCADTagType2Data object.
	 * @param  workingContext            Working context
	 * @return                           CompressedCADTagType2Data instance
	 * @throws UnsupportedCodecException Thrown, when an unsupported codec has been found
	 */
	public static CompressedCADTagType1Data read(WorkingContext workingContext) throws UnsupportedCodecException {
		return new CompressedCADTagType1Data(	Int32CDP2.readVecI32(workingContext, PredictorType.PredLag1),
												Int32CDP2.readVecI32(workingContext, PredictorType.PredLag1));
	}
}