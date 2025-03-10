CREATE TABLE BRANDS (
                        ID INT PRIMARY KEY,                    -- Identificador único de la marca
                        NAME VARCHAR(255) NOT NULL             -- Nombre de la marca
);

CREATE TABLE PRICES (
                        ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                        BRAND_ID INT NOT NULL,
                        START_DATE TIMESTAMP NOT NULL,
                        END_DATE TIMESTAMP NOT NULL,
                        PRICE_LIST INT NOT NULL,
                        PRODUCT_ID INT NOT NULL,
                        PRIORITY INT NOT NULL,
                        PRICE DECIMAL(10,2) NOT NULL,
                        CURR VARCHAR(3) NOT NULL,
                        FOREIGN KEY (BRAND_ID) REFERENCES brands(ID)  -- Relación con la tabla brands

);