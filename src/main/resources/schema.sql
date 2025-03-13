CREATE TABLE BRANDS (
                        ID INT PRIMARY KEY,
                        NAME VARCHAR(255) NOT NULL
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
                        FOREIGN KEY (BRAND_ID) REFERENCES brands(ID)

);

-- Create index for the PRICES table
CREATE INDEX idx_product_id ON PRICES (PRODUCT_ID);
CREATE INDEX idx_brand_id ON PRICES (BRAND_ID);
CREATE INDEX idx_start_date ON PRICES (START_DATE);
CREATE INDEX idx_end_date ON PRICES (END_DATE);