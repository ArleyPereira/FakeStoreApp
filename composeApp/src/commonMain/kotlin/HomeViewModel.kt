import data.mapper.toDomain
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.model.Product
import domain.usecase.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(listOf())
    val products = _products.asStateFlow()

    init {
        viewModelScope.launch {
            getProductsUseCase().collectLatest { products ->
                _products.update { products.map { it.toDomain() } }
            }
        }
    }

}