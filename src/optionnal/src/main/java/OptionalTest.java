import java.util.Optional;

public class OptionalTest {

    /**
     * Returns an Optional<TeamLeader> object from teamLeader
     */
    public Optional<TeamLeader> createOptionalTeamLeader(TeamLeader teamLeader) {
        return Optional.ofNullable(teamLeader);
    }

    /**
     * Increments the age of teamLeader by one
     */
    public void incAge(Optional<TeamLeader> optionalTeamLeader) {
        optionalTeamLeader.map((t)->{t.setAge(t.getAge()+1);return t;});
    }

    /**
     * Increments the age of teamLeader by one only if its age is > 15
     */
    public void incAgeIfMoreThanFifteen(Optional<TeamLeader> optionalTeamLeader) {
        optionalTeamLeader.map((t)->{if(t.getAge()>15){t.setAge(t.getAge()+1);}return t;});
    }

    /**
     * Returns the name of the teamLeader or "No team leader"
     */
    public String getName(Optional<TeamLeader> optionalTeamLeader) {
        return optionalTeamLeader.map((t)->t.getName()).orElse("No team leader");
    }

    /**
     * Returns the name of the teamLeader of the team of the person or "No team leader"
     */
    public String getNameOfTeamLeader(Optional<Person> optionalPerson) {
        return getName(optionalPerson.orElse(new Person()).getTeam().get().getTeamLeader());
    }
}
