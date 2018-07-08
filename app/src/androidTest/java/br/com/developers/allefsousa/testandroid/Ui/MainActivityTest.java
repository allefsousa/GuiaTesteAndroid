package br.com.developers.allefsousa.testandroid.Ui;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.developers.allefsousa.testandroid.R;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Created by allef on 07/07/2018.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    public static final String STRING_TO_BE_TYPED = "Espresso";


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    /**
     * Verificando o estado da view ao ser criada
     * e se todos os elementos dela estão sendo exibidos
     */
    @Test
    public void testEstadoView() {
        onView(withId(R.id.editusuario)).check(matches(isDisplayed()));
        onView(withId(R.id.editsenha)).check(matches(isDisplayed()));
        onView(withId(R.id.btnOk)).check(matches(isDisplayed()));

    }

    /**
     * Verificando campos em branco
     */
    @Test
    public void editTextUsuarioVazio(){
        testEmptyFieldState(R.id.editusuario);
    }

    @Test
    public void editTextSenhaVazio(){
        testEmptyFieldState(R.id.editsenha);
    }

    private void testEmptyFieldState(int notEmptyFieldId){
        onView(withId(notEmptyFieldId)).perform(typeText("defaultText"),closeSoftKeyboard());
        onView(withId(R.id.btnOk)).perform(click());

    }

    //region Duas formas de testar intents
    @Test
    public void testAbrirOutraActivity() {
        Intents.init();

        onView(withId(R.id.editsenha)).perform(typeText("username"), closeSoftKeyboard());
        onView(withId(R.id.editusuario)).perform(typeText("password"), closeSoftKeyboard());

        Matcher<Intent> matcher = hasComponent(MainActivity.class.getName());

        onView(withId(R.id.btnOk)).perform(click());

        intended(matcher);

        Intents.release();
    }

    /**
     * OU DESSA FORMA
     */
    @Test
    public void whenBothFieldsAreFilled_andClickOnLoginButton_shouldOpenMainActivity() {
        Intents.init();
        onView(withId(R.id.editusuario)).perform(typeText("defaultText"), closeSoftKeyboard());
        onView(withId(R.id.editsenha)).perform(typeText("defaultText"), closeSoftKeyboard());
        Matcher<Intent> matcher = hasComponent(MainActivity.class.getName());

        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, null);
        intending(matcher).respondWith(result);

        onView(withId(R.id.btnOk)).perform(click());
        intended(matcher);
        Intents.release();
    }
    //endregion



    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editusuario))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.btnOk)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.editusuario)).check(matches(withText(STRING_TO_BE_TYPED)));
    }

    @Test
    public void changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editusuario)).perform(typeText(STRING_TO_BE_TYPED),
                closeSoftKeyboard());
        onView(withId(R.id.btnOk)).perform(click());

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.editusuario)).check(matches(withText(STRING_TO_BE_TYPED)));
    }

}