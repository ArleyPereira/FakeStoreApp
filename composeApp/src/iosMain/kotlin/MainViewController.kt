import androidx.compose.ui.window.ComposeUIViewController
import core.app.App
import di.dataModule
import di.domainModule
import di.networkModule
import di.presentationModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController { App() }

fun initKoin() {
    startKoin {
        modules(
            domainModule,
            networkModule,
            presentationModule,
            dataModule
        )
    }
}