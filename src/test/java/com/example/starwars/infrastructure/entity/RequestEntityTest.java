package com.example.starwars.infrastructure.entity;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class RequestEntityTest {

    @Test
    void testRequestEntityGettersAndSetters() {
        // Arrange
        Result result = getResult();

        // Act
        RequestEntity requestEntity = getRequestEntity(result);

        // Assert
        assertThat(requestEntity.getBrandId()).isEqualTo(result.brandId());
        assertThat(requestEntity.getProductId()).isEqualTo(result.productId());
        assertThat(requestEntity.getApplicationDate()).isEqualTo(result.applicationDate());
    }

    @Test
    void testRequestEntityNoArgsConstructor() {
        // Act
        RequestEntity requestEntity = new RequestEntity();

        // Assert
        assertThat(requestEntity.getBrandId()).isZero();
        assertThat(requestEntity.getProductId()).isZero();
        assertThat(requestEntity.getApplicationDate()).isNull();
    }

    private static RequestEntity getRequestEntity(Result result) {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setBrandId(result.brandId());
        requestEntity.setProductId(result.productId());
        requestEntity.setApplicationDate(result.applicationDate());
        return requestEntity;
    }

    private static Result getResult() {
        int brandId = 1;
        int productId = 12345;
        String applicationDate = "2024-08-15T10:00:00";
        return new Result(brandId, productId, applicationDate);
    }

    private record Result(int brandId, int productId, String applicationDate) {
    }
}
