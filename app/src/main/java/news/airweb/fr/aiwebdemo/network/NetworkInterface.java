package news.airweb.fr.aiwebdemo.network;


import io.reactivex.Observable;
import news.airweb.fr.aiwebdemo.models.Content;
import retrofit2.http.GET;


public interface NetworkInterface {

    @GET("psg.json")
    Observable<Content> getNews();

}
