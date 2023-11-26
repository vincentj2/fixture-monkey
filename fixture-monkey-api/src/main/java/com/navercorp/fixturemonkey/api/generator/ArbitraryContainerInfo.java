/*
 * Fixture Monkey
 *
 * Copyright (c) 2021-present NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.navercorp.fixturemonkey.api.generator;

import java.util.Objects;

import org.apiguardian.api.API;
import org.apiguardian.api.API.Status;

import com.navercorp.fixturemonkey.api.random.Randoms;

@API(since = "0.4.0", status = Status.MAINTAINED)
public final class ArbitraryContainerInfo {
	private final int elementMinSize;
	private final int elementMaxSize;

	/**
	 * Constructs an object represents a size of container.
	 * It may be manipulated or not manipulated depends on existence of manipulatedSequence.
	 *
	 * @param elementMinSize the min size of the container
	 * @param elementMaxSize the max size of the container
	 */
	public ArbitraryContainerInfo(int elementMinSize, int elementMaxSize) {
		this.elementMinSize = elementMinSize;
		this.elementMaxSize = elementMaxSize;
	}

	public int getElementMinSize() {
		return this.elementMinSize;
	}

	public int getElementMaxSize() {
		return this.elementMaxSize;
	}

	public int getRandomSize() {
		if (this.elementMinSize == this.elementMaxSize) {
			return this.elementMinSize;
		}

		return this.elementMinSize + Randoms.nextInt(this.elementMaxSize - this.elementMinSize + 1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		ArbitraryContainerInfo that = (ArbitraryContainerInfo)obj;
		return elementMinSize == that.elementMinSize && elementMaxSize == that.elementMaxSize;
	}

	@Override
	public int hashCode() {
		return Objects.hash(elementMinSize, elementMaxSize);
	}

	@Override
	public String toString() {
		return "ArbitraryPropertyContainerInfo{"
			+ "elementMinSize=" + elementMinSize
			+ ", elementMaxSize=" + elementMaxSize
			+ '}';
	}
}
