# Fixture Monkey
![Maven version](https://maven-badges.herokuapp.com/maven-central/com.navercorp.fixturemonkey/fixture-monkey/badge.svg)
[![Build](https://github.com/naver/fixture-monkey/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/naver/fixture-monkey/actions/workflows/build.yml)
[![GitHub license](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/naver/fixture-monkey/blob/main/LICENSE)

<figure align="center">
    <img src= "https://user-images.githubusercontent.com/10272119/132285552-3af3ef55-e211-4dff-bb47-83d563ad6046.png" width="85%"/>
    <figcaption>Designed by <a href="https://www.behance.net/zziyeoon">Judy Kim </a> <figcaption>
</figure>


### "Write once, Test anywhere"

Fixture Monkey is designed to generate controllable arbitrary instances easily. It allows you to reuse same configurations of the instances in several tests.

You can write countless tests including edge cases by only one instance of the FixtureMonkey type. You can generate instances of complex types automatically and set fields with values from builders of the ArbitraryBuilder<T> type. The well-defined builders could be reused in any tests. Writing integration tests is easier with Fixture Monkey.
    
Each primitive type property is generated by [Jqwik](https://github.com/jlink/jqwik)


## Example

```java

@Data   // lombok getter, setter
public class Order {
    @NotNull
    private Long id;

    @NotBlank
    private String orderNo;

    @Size(min = 2, max = 10)
    private String productName;

    @Min(1)
    @Max(100)
    private int quantity;

    @Min(0)
    private long price;

    @Size(max = 3)
    private List<@NotBlank @Size(max = 10) String> items = new ArrayList<>();

    @PastOrPresent
    private Instant orderedAt;

    @Email
    private String sellerEmail;
}

@Test
void test() {
    // given
    FixtureMonkey sut = FixtureMonkey.create();

    // when
    Order actual = sut.giveMeOne(Order.class);

    // then
    then(actual.getId()).isNotNull();
}
```

## Requirements

* JDK 1.8 or higher
* Jqwik 1.3.9

## Install

### Gradle

```groovy
testImplementation("com.navercorp.fixturemonkey:fixture-monkey-starter:0.3.5")
```

### Maven

```xml

<dependency>
    <groupId>com.navercorp.fixturemonkey</groupId>
    <artifactId>fixture-monkey-starter</artifactId>
    <version>0.3.5</version>
    <scope>test</scope>
</dependency>
```

## Documentation
https://naver.github.io/fixture-monkey/

## Third-party Modules

* fixture-monkey-starter
  - Supports including default dependency descriptors fore helping quick start.
* fixture-monkey-jackson
  - Supports [jackson](https://github.com/FasterXML/jackson) Serialize/Deserialize object generation.
* fixture-monkey-kotlin
  - Supports Kotlin.
* fixture-monkey-autoparams (Experimental)
  - Extends [AutoParams](https://github.com/JavaUnit/AutoParams) to support parameterized tests.
* fixture-monkey-mockito (Experimental)
  - Supports for generating interfaces and abstract classes as [mockito](https://github.com/mockito/mockito) objects.

## License

```
Copyright 2021-present NAVER Corp.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
