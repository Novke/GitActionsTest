package rs.fon.silab.rest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }

}
