package Base;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;

import java.lang.reflect.Method;

public class AllureListener implements AfterTestExecutionCallback {

    /**
     * ����� ���������� ��������� � ������ ������ ����� ���������
     * @param screenShot ����� ����������
     * @return
     */
//    @Attachment(value = "Page screenshot", type = "image/png", fileExtension = ".png")
//    public static byte[] saveScreenshot(byte[] screenShot) {
//        return screenShot;
//    }

    /**
     * ��������������� ������ ���������� ������ � juni5
     * @param context �������� �����
     */
    @Override
    public void afterTestExecution(ExtensionContext context) {
        Method testMethod = context.getRequiredTestMethod(); //�������� �������� �����
        String testName = testMethod.getName(); //�������� �������� ��������� ������
        boolean testFailed = context.getExecutionException().isPresent();//��������� ���� �� ����
        if (testFailed) {//���� ���� ����
            if (!testName.contains("Screenshot")) {//���� �������� ������ �� �������� Screenshot
//                saveScreenshot(Selenide.screenshot(OutputType.BYTES)); //��������� �������� � �������� �����
                Allure.getLifecycle().addAttachment("Page Screenshot", "image/png", "png", Selenide.screenshot(OutputType.BYTES));
            }
        }
    }
}
