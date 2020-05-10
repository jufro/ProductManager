package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data

    public class Product {
        private int id;
        private String name;
        private int price;

        public boolean matches(String search) {
            if (this.getName().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
    }
