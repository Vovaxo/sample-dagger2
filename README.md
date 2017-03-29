# sample-dagger2
This is sample project that implement dagger2 new api dagger.android
One of the central difficulties of writing an Android application using Dagger is that many Android framework classes are instantiated by the OS itself, like `Activity` and `Fragment`, but Dagger works best if it can create all the injected objects. Instead, you have to perform members injection in a lifecycle method.
Starting from version 2.10 dagger allows using `dagger.android` which simplify using dagger with android components.

**Injecting Activity objects**

 1. Install `AndroidInjectionModule` in your application component to ensure that all bindings necessary for these base types are available.

        @Component(modules = {AndroidInjectionModule.class})
        public interface AppComponent {}
 2. Start off by writing a `@Subcomponent` that implements [AndroidInjector<YourActivity>][AndroidInjector], with a `@Subcomponent.Builder` that extends [AndroidInjector.Builder<YourActivity>][AndroidInjector.Builder]:

        @Subcomponent
        public interface MainActivityComponent extends AndroidInjector<MainActivity> {
            @Subcomponent.Builder
            abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
        }
 3. After defining the subcomponent, add it to your component hierarchy by defining a module that binds the subcomponent builder and adding it to the component that injects your `Application`:

        @Module(subcomponents = MainActivityComponent.class)
        public abstract class MainActivityModule {

            @Binds @IntoMap @ActivityKey(MainActivity.class)
            abstract AndroidInjector.Factory<? extends Activity>
            bindMainActivityInjectorFactory(MainActivityComponent.Builder builder);
        }
 4. Next, make your `Application` implement `HasDispatchingActivityInjector` and `@Inject` a `DispatchingAndroidInjector<Activity>` to return from the activityInjector() method:

        public class MyApp extends Application implements HasDispatchingActivityInjector     {

            @Inject
            DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

            @Override
            public void onCreate() {
               super.onCreate();
               DaggerAppComponent.create().inject(this);
            }

            @Override
            public DispatchingAndroidInjector<Activity> activityInjector() {
                return dispatchingActivityInjector;
            }
        }

 5. Finally, in your Activity.onCreate() method, call AndroidInjection.inject(this) before calling super.onCreate();:

        public class MainActivity extends Activity {
            public void onCreate(Bundle savedInstanceState) {
                AndroidInjection.inject(this);
                super.onCreate(savedInstanceState);
            }
        }

This example was based on [official dagger documentation][1].
    


  [1]: https://google.github.io/dagger/android.html
