public class StudentForm {
    @NotBlank @MaxLength(20) private String name;
    @NotBlank @MaxLength(40) private String email;
    public StudentForm(String name, String email) { this.name = name; this.email = email; }
}
