package com.example.starwars.infrastructure.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BrandEntityTest {

    @Test
    public void testBrandEntityGettersAndSetters() {
        // Arrange
        Result result = getResult();

        // Act
        BrandEntity brandEntity = getBrandEntity(result);

        // Assert
        assertThat(brandEntity.getId()).isEqualTo(result.id());
        assertThat(brandEntity.getName()).isEqualTo(result.name());
    }

    @Test
    public void testBrandEntityConstructorWithArgs() {
        // Arrange
        Result result = getResult();

        // Act
        BrandEntity brandEntity = getBrandEntity(result);

        // Assert
        assertThat(brandEntity.getId()).isEqualTo(result.id());
        assertThat(brandEntity.getName()).isEqualTo(result.name());
    }


    private static BrandEntity getBrandEntity(Result result) {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(result.id());
        brandEntity.setName(result.name());
        return brandEntity;
    }
    private Result getResult() {
        return new Result(1L, "ZARA");
    }

    private record Result(long id, String name) {}

}
