/**
 * Copyright (c) 2013 SAP
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the SAP nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL SAP BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/**
 * 
 */
package org.sopeco.plugin.std.exploration.screening.extensions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.sopeco.engine.experimentseries.IExplorationStrategy;
import org.sopeco.engine.experimentseries.IExplorationStrategyExtension;
import org.sopeco.plugin.std.exploration.screening.ScreeningDesignExploration;

/**
 * Abstract extension that provides the methods common to all screening exploration
 * strategy extensions.
 * 
 * @author Dennis Westermann
 * 
 */
public abstract class AbstractScreeningExplorationExtension implements IExplorationStrategyExtension {

	/** Holds a mapping of configuration parameters to their optional default values. */
	protected final Map<String, String> configParams = new HashMap<String, String>();

	

	protected AbstractScreeningExplorationExtension() {
		prepareConfigurationParameterMap();
	}

	
	@Override
	public IExplorationStrategy createExtensionArtifact() {
		return new ScreeningDesignExploration(this);
	}

	/**
	 * Called by the constructor of this class to prepare
	 * the set of configuration parameters ({@link #configParams}).
	 */
	protected abstract void prepareConfigurationParameterMap();

	@Override
	public Map<String, String> getConfigParameters() {
		return Collections.unmodifiableMap(configParams);
	}


}
