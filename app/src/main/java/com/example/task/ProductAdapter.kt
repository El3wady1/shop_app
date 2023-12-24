import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task.R

class ProductAdapter(private val products: List<Product>) :

    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textProductName: TextView = itemView.findViewById(R.id.textProductName)
        val textProductPrice: TextView = itemView.findViewById(R.id.textProductPrice)
        val productImage: ImageView = itemView.findViewById(R.id.productimage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //get items and inflate
        // send items
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    //relate
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = products[position]
        holder.textProductName.text = product.title
        holder.textProductPrice.text = "$${product.price}"
        Glide.with(holder.itemView.context).load(product.image).into(holder.productImage)

    }

    override fun getItemCount(): Int {
        return products.size
    }
}
