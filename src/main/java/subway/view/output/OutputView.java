package subway.view.output;

public class OutputView {

    public void printView(View view) {
        print(view.getText());
    }

    public void printErrorMessage(Exception exception) {
        print(exception.getMessage());
    }

    private void print(String string) {
        System.out.println(string);
    }
}
