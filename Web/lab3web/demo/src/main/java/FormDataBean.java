import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.faces.context.FacesContext;
import jakarta.faces.component.UIComponent;

import java.io.IOException;
import java.io.Serializable;

@Named
@ApplicationScoped
public class FormDataBean implements Serializable {
    private int x;
    private double y ;
    private double r = 1;
    private String errorMessage;

    // Геттеры и сеттеры
    public void setX(int x) { this.x = x; }
    public void updateX(int value) {
        this.x = value;
        this.errorMessage = ""; // Очистить сообщение об ошибке
    }
    public double getY() { return y; }

    public int getX() {
        return x;
    }

    public void setY(double y) { this.y = y; }

    public double getR() { return r; }
    public void setR(double r) { this.r = r; }
    public void submitAction() throws ValidatorException, IOException {
        System.out.println(x + " : " + y + " : " + r);
        if(x >= -3 && x <= 5 && y >= -3 && y <= 5 && r >= 1 && y <= 3) {
            new AddDataToDatabase(new Point(x ,y ,r));
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                String currentUrl = context.getExternalContext().getRequestContextPath();
                context.getExternalContext().redirect(currentUrl + "/main.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ошибка: "));
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void validateSelectY(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null) {
            FacesMessage message = new FacesMessage("Please, input Y!");
            throw new ValidatorException(message);
        }
    }
}
