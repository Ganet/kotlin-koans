package v_builders

import v_builders.data.getProducts
import v_builders.htmlLibrary.*
import util.*

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) % 2 == 0) "#dce4ff" else "#eff2ff"

fun todoTask39(): Nothing = TODO(
        """
        Task 39.
        1) Fill the table with the proper values from products.
        2) Color the table like a chess board (using getTitleColor() and getCellColor() functions above).
        Pass a color as an argument to functions 'tr', 'td'.
        You can run the 'Html Demo' configuration in IntelliJ to see the rendered table.
    """,
        documentation = doc39()
)

fun renderProductTable(): String {
    return html {
        table {
            tr(color = getTitleColor()) {

                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts();
            for (row in products.indices) {
                tr(getCellColor(row, 0)){
                    td (getCellColor(row, 1)) {
                        text(products[row].description)
                    }
                    td (getCellColor(row, 2)){
                        text(products[row].price)
                    }
                    td (getCellColor(row, 3)){
                        text(products[row].popularity)
                    }
                }
            }
        }
    }.toString()
}
