package rocks.zipcode.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rocks.zipcode.service.CategoryService;

@RestController
@RequestMapping("/news")
public class CategoryController {


        @Autowired
        private CategoryService categoryService;

        @GetMapping("/{world}")
        public String getCategory(@PathVariable String world) {
            return categoryService.getNewsByCategory(world);
        }
    }


