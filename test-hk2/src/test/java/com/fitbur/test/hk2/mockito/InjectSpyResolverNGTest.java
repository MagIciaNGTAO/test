/*
 * Copyright 2014 Fitbur.
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
package com.fitbur.test.hk2.mockito;

import com.fitbur.test.hk2.fixture.PrimeryService;
import static org.assertj.core.api.Assertions.assertThat;
import org.jvnet.testing.hk2testng.HK2;
import static org.mockito.Mockito.verify;
import org.testng.annotations.Test;

/**
 *
 * @author Sharmarke Aden
 */
@HK2
public class InjectSpyResolverNGTest {

    @InjectSpy
    PrimeryService service;

    @Test
    public void assertInjection() {
        assertThat(service).isNotNull();
    }

    @Test
    public void verifyMethodCall() {
        String result = service.say();
        assertThat(result).isEqualTo("hello!");
        verify(service).say();
        verify(service).hello();
    }

}
