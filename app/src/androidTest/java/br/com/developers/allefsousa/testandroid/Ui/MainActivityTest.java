package br.com.developers.allefsousa.testandroid.Ui;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.developers.allefsousa.testandroid.R;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
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