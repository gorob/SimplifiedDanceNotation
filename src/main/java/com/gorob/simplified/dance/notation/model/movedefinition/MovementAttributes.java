package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.model.movedefinition.enums.Course;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Direction;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Distance;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Rotation;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovementAttributes {
    private Direction direction;
    private Course course;
    private Distance distance;
    private Rotation rotation;
}
