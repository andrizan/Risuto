package com.lexwilliam.data.mapper

import com.lexwilliam.data.model.remote.anime.AnimeDetailRepo
import com.lexwilliam.domain.model.remote.anime.AnimeDetail
import javax.inject.Inject

interface DetailMapper {
    fun toDomain(detail: AnimeDetailRepo): AnimeDetail
}

class DetailMapperImpl @Inject constructor(): DetailMapper {
    override fun toDomain(detail: AnimeDetailRepo): AnimeDetail =
        AnimeDetail(toDomain(detail.alternative_titles), detail.average_episode_duration, detail.background, toDomain(detail.broadcast), detail.created_at, detail.end_date, detail.genres.map { toDomain(it) }, detail.id, toDomain(detail.main_picture), detail.mean, detail.media_type, toDomain(detail.my_list_status), detail.nsfw, detail.num_episodes, detail.num_list_users, detail.num_scoring_users, detail.pictures.map { toDomain(it) }, detail.popularity, detail.rank, detail.rating, detail.recommendations.map { toDomain(it) }, detail.related_anime.map { toDomain(it) }, detail.related_manga, detail.source, detail.start_date, toDomain(detail.start_season), toDomain(detail.statistics), detail.status, detail.studios.map { toDomain(it) }, detail.synopsis, detail.title, detail.updated_at)

    private fun toDomain(alter: AnimeDetailRepo.AlternativeTitles): AnimeDetail.AlternativeTitles =
        AnimeDetail.AlternativeTitles(alter.en, alter.ja, alter.synonyms)

    private fun toDomain(broadcast: AnimeDetailRepo.Broadcast): AnimeDetail.Broadcast =
        AnimeDetail.Broadcast(broadcast.day_of_the_week, broadcast.start_time)

    private fun toDomain(genre: AnimeDetailRepo.Genre): AnimeDetail.Genre =
        AnimeDetail.Genre(genre.id, genre.name)

    private fun toDomain(mainPicture: AnimeDetailRepo.MainPicture): AnimeDetail.MainPicture =
        AnimeDetail.MainPicture(mainPicture.large, mainPicture.medium)

    private fun toDomain(status: AnimeDetailRepo.MyListStatus): AnimeDetail.MyListStatus =
        AnimeDetail.MyListStatus(status.is_rewatching, status.num_episodes_watched, status.score, status.status, status.updated_at)

    private fun toDomain(node: AnimeDetailRepo.Node): AnimeDetail.Node =
        AnimeDetail.Node(node.id, toDomain(node.main_picture), node.title)

    private fun toDomain(picture: AnimeDetailRepo.Picture): AnimeDetail.Picture =
        AnimeDetail.Picture(picture.large, picture.medium)

    private fun toDomain(recommendation: AnimeDetailRepo.Recommendation): AnimeDetail.Recommendation =
        AnimeDetail.Recommendation(toDomain(recommendation.node), recommendation.num_recommendations)

    private fun toDomain(relatedAnime: AnimeDetailRepo.RelatedAnime): AnimeDetail.RelatedAnime =
        AnimeDetail.RelatedAnime(toDomain(relatedAnime.node), relatedAnime.relation_type, relatedAnime.relation_type_formatted)

    private fun toDomain(startSeason: AnimeDetailRepo.StartSeason): AnimeDetail.StartSeason =
        AnimeDetail.StartSeason(startSeason.season, startSeason.year)

    private fun toDomain(statistics: AnimeDetailRepo.Statistics): AnimeDetail.Statistics =
        AnimeDetail.Statistics(statistics.num_list_users, toDomain(statistics.status))

    private fun toDomain(status: AnimeDetailRepo.Status): AnimeDetail.Status =
        AnimeDetail.Status(status.completed, status.dropped, status.on_hold, status.plan_to_watch, status.watching)

    private fun toDomain(studio: AnimeDetailRepo.Studio): AnimeDetail.Studio =
        AnimeDetail.Studio(studio.id, studio.name)
}