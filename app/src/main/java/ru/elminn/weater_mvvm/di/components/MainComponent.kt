package ru.elminn.weater_mvvm.di.components

import dagger.Subcomponent
import ru.elminn.weater_mvvm.di.module.ScreenModule
import ru.elminn.weater_mvvm.ui.DayForecastActivity


@Subcomponent(modules = [ ScreenModule::class])
interface MainComponent {

    fun injectDayForecastActivity(activity: DayForecastActivity)
   /* fun injectLoginFragment(fragment: LoginFragment)

    fun injectRegistrationFragment(fragment: RegistrationFragment)

    fun injectAvatarFragment(fragment: AvatarFragment)

    fun injectStartFragment(fragment: StartFragment)

    //Main

    fun injectSwipeFragment(fragment: SwipeFragment)

    fun injectProfileFragment(fragment: ProfileFragment)

    fun injectSympathyListFragment(fragment: MySympathyListFragment)

    fun injectMyCityListFragment(fragment: MyCityListFragment)

    fun injectGuestsListFragment(fragment: GuestsListFragment)

    fun injectMessagesFragment(fragment: MessagesFragment)

    fun injectAddStoryFragment(fragment: AddStoryFragment)

    fun injectStoryFragment(fragment: StoryFragment)

    //Inside

    fun injectProfileDetailed(fragment: ProfileDetailedFragment)

    fun injectProfileEdit(fragment: ProfileEditFragment)

    fun injectProfileEducationFragment(fragment: EducationFragment)

    fun injectProfileSettingsFragment(fragment: ProfileSettingsFragment)*/
}
