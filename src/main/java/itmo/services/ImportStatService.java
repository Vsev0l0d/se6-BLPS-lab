package itmo.services;

import itmo.model.ImportStat;
import itmo.repositories.ImportStatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ImportStatService {
    private final ImportStatRepository importStatRepository;

    @Autowired
    public ImportStatService(ImportStatRepository importStatRepository) {
        this.importStatRepository = importStatRepository;
    }

    public String generateEmailText(String ownerMail){
        StringBuilder text = new StringBuilder();
        List<ImportStat> importStats = importStatRepository.findByOwnerMail(ownerMail);
        Map<String, List<ImportStat>> res = importStats.stream().collect(Collectors.groupingBy(ImportStat::getPlaylistName));
        for(Map.Entry<String, List<ImportStat>> item : res.entrySet()){
            text.append("Playlist '").append(item.getKey()).append("' has been imported by users:\n\t");
            Iterator<ImportStat> iterator = item.getValue().iterator();
            while (iterator.hasNext()){
                text.append(iterator.next().getImporterName());
                if (iterator.hasNext()) text.append(", ");
            }
            text.append("\n");
        }
        return text.toString();
    }
}
